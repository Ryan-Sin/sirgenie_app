package com.sirgenie.sirgenie_app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="banking", schema="Sirgenie")
public class Banking {

    @Tolerate
    public Banking() {}

    public Banking(String period, Double utilization, Double phone, Double note_book) {
        this.period = period;
        this.utilization = utilization;
        this.phone = phone;
        this.note_book = note_book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "period", nullable = false)
    private String period;

    @Column(name = "utilization", nullable = false)
    private Double utilization;

    @Column(name = "phone", nullable = false)
    private Double phone;

    @Column(name = "note_book", nullable = false)
    private Double note_book;

    @Override
    public String toString() {
        return "Banking{" +
                "period='" + period + '\'' +
                ", utilization=" + utilization +
                ", phone=" + phone +
                ", note_book=" + note_book +
                '}';
    }
}
