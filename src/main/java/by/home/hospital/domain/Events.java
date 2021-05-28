package by.home.hospital.domain;

import by.home.hospital.Enum.StatEvents;
import by.home.hospital.Enum.TypeEvents;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Name;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Name("events_id")
    private Integer id;
    // id patient not user id
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientDetails patient;

    @Enumerated(EnumType.STRING)
    private TypeEvents typeEvents;

    @Enumerated(EnumType.STRING)
    private StatEvents statEvents;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "workingDay_id")
    private WorkingDay workingDay;

    private Time startTimeWork;

    private Time endTimeWork;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "events", fetch = FetchType.LAZY)
    private Action action;
}
