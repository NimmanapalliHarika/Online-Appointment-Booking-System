package com.twg.sprg.rest.Entity;

import java.time.LocalDateTime;

import com.twg.sprg.rest.Enums.AppointmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="professional_id",nullable = false)
	private Professional professional;
	
	@Column(name = "AppointmentDate")
	private LocalDateTime appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;
	
}
