package by.home.hospital.domain;

import by.home.hospital.Enum.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Name;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Name("workingDay_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private Time startTimeWork;

    private Time endTimeWork;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "workingDay", cascade = CascadeType.REMOVE)
    private List<Events> eventsList;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "doctorDetails_id")
    private DoctorDetails doctorDetails;
}
