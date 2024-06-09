package eapli.base.protocol.dto;

import eapli.base.domain.jobOpening.*;
import eapli.base.domain.jobOpeningProcess.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class JobOpeningDTO implements Serializable {

    public  String jobReference;
    public  String description;
    public  String address;
    public  String mode;
    public  String contractType;
    public  String titleOrFunction;
    public  int vacanciesNumber;
    public  String companyName;
    public LocalDateTime creationDate;
    public String interviewModel;
    public String requirements;

    public  Status status;

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


}



