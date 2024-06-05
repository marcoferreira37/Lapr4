package eapli.base.protocol.dto;

import eapli.base.domain.jobOpening.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class JobOpeningDTO implements Serializable {

    private String jobReference;
    private String description;
    private String address;
    private String mode;
    private String contractType;
    private String titleOrFunction;
    private int vacanciesNumber;
    private String companyName;
    private LocalDateTime creationDate;
    private String interviewModel;
    private String requirements;

    public JobOpeningDTO(JobReference jobReference, Description description, Address address, Mode mode, ContractType contractType, TitleOrFunction titleOrFunction, VacanciesNumber vacanciesNumber, String company , Calendar creationDate, String interviewModel, String requirements) {
        this.jobReference = jobReference.toString();
        this.description = description.toString();
        this.address = address.toString();
        this.mode = mode.toString();
        this.contractType = contractType.toString();
        this.titleOrFunction = titleOrFunction.toString();
        this.vacanciesNumber = vacanciesNumber.getNumber();
        this.companyName = company;
        this.creationDate = LocalDateTime.ofInstant(creationDate.toInstant(), creationDate.getTimeZone().toZoneId());
        this.interviewModel = interviewModel;
        this.requirements = requirements;
        this.creationDate = LocalDateTime.ofInstant(creationDate.toInstant(), creationDate.getTimeZone().toZoneId());
        this.interviewModel = interviewModel;
        this.requirements = requirements;
    }

    public String getJobReference() {
        return jobReference;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getMode() {
        return mode;
    }

    public String getContractType() {
        return contractType;
    }

    public String getTitleOrFunction() {
        return titleOrFunction;
    }

    public int getVacanciesNumber() {
        return vacanciesNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getInterviewModel() {
        return interviewModel;
    }

    public String getRequirements() {
        return requirements;
    }
}



