package com.practice.hackathon.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
public class Plan {

    @Id
    private int planId;
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "^[a-zA-Z\\s]+$")
    private String planName;
    @Positive
    private int planCost;
    @NotNull
    @Size(min = 5, max = 100)
    private String planDescription;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getPlanCost() {
        return planCost;
    }

    public void setPlanCost(int planCost) {
        this.planCost = planCost;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public Plan() {
    }

    public Plan(int planId, String planName, int planCost, String planDescription) {
        this.planId = planId;
        this.planName = planName;
        this.planCost = planCost;
        this.planDescription = planDescription;
    }
}
