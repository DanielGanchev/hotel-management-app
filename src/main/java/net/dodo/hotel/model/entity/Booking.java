package net.dodo.hotel.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Check-in date is mandatory")
  private LocalDate checkInDate;

  @Future(message = "Check-out date must be in the future")
  private LocalDate checkOutDate;

  @Min(value = 1, message = "Number of adults must be at least 1")
  private int numberOfAdults;
  private int numberOfChildren;
  @Min(value = 1, message = "Total number of guests must be at least 1")
  private int totalNumberOfGuests;
  private String bookConfirmationCode;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_id")
  private Room room;

  private void calculateTotalNumberOfGuests() {
    this.totalNumberOfGuests = this.numberOfAdults + this.numberOfChildren;
  }

  public void setNumberOfAdults(int numberOfAdults) {
    this.numberOfAdults = numberOfAdults;
    calculateTotalNumberOfGuests();
  }

  public void setNumberOfChildren(int numberOfChildren) {
    this.numberOfChildren = numberOfChildren;
    calculateTotalNumberOfGuests();
  }



}