package br.com.dio.barber_shop_iu.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = "CLIENTS",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
                @UniqueConstraint(name = "UK_PHONE", columnNames = "phone")
        }
)
public class ClientEntity {

        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;

        @Column(nullable = false, length = 150)
        private String name;

        @Column(nullable = false, length = 150)
        private String email;

        @Column(nullable = false, length = 11, columnDefinition = "varchar(11)")
        private String phone;

        @OneToMany(mappedBy = "client", cascade = ALL, orphanRemoval = true)
        private Set<ScheduleEntity> schedules = new HashSet<>();

        public Set<ScheduleEntity> getSchedules() {
                return schedules;
        }

        public void setSchedules(Set<ScheduleEntity> schedules) {
                this.schedules = schedules;
        }

        @Override
        public String toString() {
                return "ClientEntity{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        ", phone='" + phone + '\'' +
                        '}';
        }

        @Override
        public boolean equals(final Object o) {
                if (!(o instanceof ClientEntity that)) return false;
                return Objects.equals(id, that.id) &&
                        Objects.equals(name, that.name) &&
                        Objects.equals(email, that.email) &&
                        Objects.equals(phone, that.phone);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, email, phone);
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }
}
