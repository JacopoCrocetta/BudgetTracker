package com.project.bebudgeting.annuale.entity.uscite;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@Table(name = "Debiti")
@NoArgsConstructor
public class DebitiEntity {
}