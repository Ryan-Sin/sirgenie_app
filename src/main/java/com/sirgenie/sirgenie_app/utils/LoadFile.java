package com.sirgenie.sirgenie_app.utils;

import com.sirgenie.sirgenie_app.domain.Banking;
import com.sirgenie.sirgenie_app.repository.BankingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class LoadFile {

    @Autowired
    private final BankingRepository bankingRepository;

    @PostConstruct
    public void loadFile() {
        try {
            this.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getFile() throws IOException {

        // 현재폴더의 디렉토리 가지고 오기.
        String path = System.getProperty("user.dir");

        //파일 정보 조회
        File file = new File(path + "/src/main/java/com/sirgenie/sirgenie_app/file/Test.csv");

        BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(file)));
        List<List<String>> content = new ArrayList<>();

        //CSV 파일을 행 단위로 묶기 위한 작업
        String line = "";
        while((line = br.readLine()) != null){
            //CSV 1행을 저장하는 리스트
            List<String> tmpList;
            String array[] = line.split(",");

            //배열에서 리스트 반환
            tmpList = Arrays.asList(array);
            content.add(tmpList);
        }

        content.remove(0); // 컬럼 정보 삭제

        for (List<String> data :content) {
            bankingRepository.save(new Banking(data.get(0), Double.valueOf(data.get(1)), Double.valueOf(data.get(2)),Double.valueOf(data.get(3))));
        }
        
        br.close();
    }
}
