package eapli.base.protocol.dto;

import eapli.base.domain.jobOpening.*;
import eapli.base.domain.jobOpeningProcess.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class JobOpeningDTO implements Serializable {

    private final String jobReference;
    private final String description;
    private final String address;
    private final String mode;
    private final String contractType;
    private final String titleOrFunction;
    private final int vacanciesNumber;
    private final String companyName;
    private LocalDateTime creationDate;
    private String interviewModel;
    private String requirements;

    private final Status status;

    public JobOpeningDTO(JobReference jobReference, Description description, Address address, Mode mode, ContractType contractType, TitleOrFunction titleOrFunction, VacanciesNumber vacanciesNumber, String company, Calendar creationDate, String interviewModel, String requirements, Status status) {
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
        this.status = status;
    }

    public String findJobReference() {
        return jobReference;
    }

    public String findCompanyName() {
        return companyName;
    }

    public Status findStatus() {
        return status;
    }
}



