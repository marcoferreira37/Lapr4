/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.domain.jobOpeningProcess.PhaseType;
import eapli.base.domain.jobOpeningProcess.Status;
import eapli.base.protocol.Notifications;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.base.repositories.NotificationsRepository;
import eapli.base.usermanagement.application.controllers.AddJobOpeningController;
import eapli.base.usermanagement.application.controllers.AddJobApplicationController;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.application.controllers.RecordInterviewController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");
        registerAdmin("barbatosRex", TestDataConstants.PASSWORD1, "Zico", "Xico", "ziquinho@proton.org");

        registerOperator("operator", TestDataConstants.PASSWORD1, "Francisco", "Monteiro", "franciscomonteiro@gmail.com");

        registerCustomerManager("customerManager", TestDataConstants.PASSWORD1, "Francisco", "Silveira", "franciscosilveira@gmail.com");
        registerCustomerManager("c",TestDataConstants.PASSWORD1,"Gaijo","Bonito","1220913@isep.ipp.pt");

        Candidate candida = registerCandidate("candida", TestDataConstants.PASSWORD1, "Candida", "Candidata", EmailAddress.valueOf("1221331@isep.ipp.pt"));
        Candidate candida2 = registerCandidate("fatima", TestDataConstants.PASSWORD1, "Fatima", "Couves", EmailAddress.valueOf("fatimaBadGirl@hotmail.com"));
        Candidate candida3 = registerCandidate("maria", TestDataConstants.PASSWORD1, "Maria", "Pereira", EmailAddress.valueOf("vozinha@gmail.com"));
        Candidate candida4 = registerCandidate("fisco", TestDataConstants.PASSWORD1, "Fisco", "Fiasco", EmailAddress.valueOf("fiascos@somosnos.com"));
        Candidate candida5 = registerCandidateWithCurriculum("fisco2", TestDataConstants.PASSWORD1, "Fisco", "Fiasco", EmailAddress.valueOf("fiascos2@somosnos.com"), "Curriculum com jopedrito a fumar ganza no parque ya");
        Candidate candida6 = registerCandidate("Francisco", TestDataConstants.PASSWORD1, "Francisco", "Silveira", EmailAddress.valueOf("1220813@isep.ipp.pt"));
        Candidate candida7 = registerCandidate("Rodrigo", TestDataConstants.PASSWORD1, "Rodrigo", "Brito", EmailAddress.valueOf("1220842@isep.ipp.pt"));
        Candidate candida8 = registerCandidate("Marco", TestDataConstants.PASSWORD1, "Marco", "Ferreira", EmailAddress.valueOf("1220913@isep.ipp.pt"));
        Candidate candida9 = registerCandidate("Gonçalo", TestDataConstants.PASSWORD1, "Gonçalo", "Sousa", EmailAddress.valueOf("1221331@isep.ipp.pt"));
        Candidate candida10 = registerCandidate("Miguel", TestDataConstants.PASSWORD1, "Miguel", "Monteiro", EmailAddress.valueOf("1221330@isep.ipp.pt"));



        JobOpening jo = registerJobOpening("bailarino", "casa do ah", Mode.ONSITE, ContractType.FULL_TIME, "baila baila", 1, 1);
        JobOpening jo2 = registerJobOpening("monstro", "o grande lago de penafiel", Mode.ONSITE, ContractType.FULL_TIME, "ARRRGHHHHHH", 1, 1);
        JobOpening jo3 = registerJobOpening("Programador com capacidades de completar o projeto de lapr4", "ISEP", Mode.ONSITE, ContractType.FULL_TIME, "Programador", 1, 1);
        JobOpening jo4 = registerJobOpening("Alguem para acordar o saco", "ISEP", Mode.ONSITE, ContractType.FULL_TIME, "Despertador", 1, 1);


        Calendar date2 = new Calendar.Builder().setDate(2026, 5, 15).build();


        JobOpening jo5 = registerJobOpening("Construtor de casas", "Rua do Ouro", Mode.ONSITE, ContractType.FULL_TIME, "Construtor", 15, 1);
        JobOpeningApplication application9 = registerApplication(jo5, candida);
        JobOpeningApplication application10 = registerApplication(jo5, candida2);
        JobOpeningApplication application11 = registerApplication(jo5, candida3);
        JobOpeningApplication application13 = registerApplication(jo, candida);
        JobInterview interview5 = registerInterview(date2, "13:00", application9);
        JobInterview interview6 = registerInterview(date2, "11:00", application10);
        JobInterview interview7 = registerInterview(date2, "12:00", application11);
        JobInterview interview8 = registerInterview(date2, "16:00", application13);
        interview5.gradeInterview(12);
        interview6.gradeInterview(15);
        interview7.gradeInterview(16);

        JobOpeningApplication application = registerApplication(jo, candida);
        JobOpeningApplication application2 = registerApplication(jo, candida2);
        JobOpeningApplication application3 = registerApplication(jo, candida3);
        JobOpeningApplication application4 = registerApplication(jo, candida4);

        NotificationsRepository notificationsRepository = PersistenceContext.repositories().notificationsRepository();
        Notifications notifications = new Notifications("admin", "You have a new notification");
        notifications.notificationFromJobOpening(jo);
        Notifications notifications2 = new Notifications("admin", "You have a new notification");
        notifications2.notificationFromJobOpening(jo2);
        notificationsRepository.save(notifications);
        notificationsRepository.save(notifications2);


        JobOpeningApplication application5 = registerApplication(jo2, candida);
        JobOpeningApplication application6 = registerApplication(jo3, candida);
        JobOpeningApplication application7 = registerApplication(jo3, candida2);
        JobOpeningApplication application8 = registerApplication(jo3, candida3);

        JobInterviewRepository jobRep = PersistenceContext.repositories().jobInterviews();

        Calendar date = new Calendar.Builder().setDate(2025, 5, 5).build();
        JobInterview interview1 = registerInterview(date, "11:00", application5);
//        System.out.println(interview1.toString());
        interview1.gradeInterview(10);
        jobRep.save(interview1);
        JobInterview interview2 = registerInterview(date, "12:00", application5);
        interview2.gradeInterview(20);
        jobRep.save(interview2);
        jobRep.save(interview5);
        jobRep.save(interview6);
        jobRep.save(interview7);

        JobInterview interview3 = registerInterview(date, "13:00", application7);
        JobInterview interview4 = registerInterview(date, "14:00", application8);

        System.out.println(candida);
        System.out.println(candida2);
        System.out.println(candida3);
        System.out.println(candida4);
        System.out.print(candida5);
        System.out.print(candida6);
        System.out.print(candida7);
        System.out.print(candida8);
        System.out.print(candida9);
        System.out.println(candida10);

        System.out.println(jo);
        System.out.println(jo2);
        System.out.println(jo3);

        System.out.println(application2);
        System.out.println(application3);
        System.out.println(application4);

        System.out.println(interview1);
        System.out.println(interview2);
        System.out.println(interview3);
        System.out.println(interview4);
        System.out.println(interview5);
        System.out.println(interview6);

        return true;
    }

    private static void registerJobOpeningProcess(JobOpeningProcess jobOpeningProcess) {
        JobOpeningProcessRepository jobOpeningProcessRepository = PersistenceContext.repositories().jobProcess();
        jobOpeningProcessRepository.save(jobOpeningProcess);
    }


    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerOperator(final String username, final String password, final String firstName,
                                  final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.OPERATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomerManager(final String username, final String password, final String firstName,
                                         final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private Candidate registerCandidate(final String username, final String password, final String firstName,
                                        final String lastName, final EmailAddress email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE);

        SystemUser u = registerUser(username, password, firstName, lastName, String.valueOf(email), roles);
        Candidate c = new Candidate(u, email, new TelephoneNumber(910920930), "curriculum");
        CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();
        candidateRepository.save(c);
        return c;
    }

    private Candidate registerCandidateWithCurriculum(final String username, final String password, final String firstName, final String lastName, final EmailAddress email, final String curriculum) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE);

        SystemUser u = registerUser(username, password, firstName, lastName, String.valueOf(email), roles);
        Candidate c = new Candidate(u, email, new TelephoneNumber(910920930), curriculum);
        CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();
        candidateRepository.save(c);
        return c;

    }

    private JobOpening registerJobOpening(String description, String address, Mode mode, ContractType contractType, String title, int vacancies, int c) {
        AddJobOpeningController controller = new AddJobOpeningController();
        return controller.addJobOpening(description, address, mode, contractType, title, vacancies, c);
    }

    private JobOpeningApplication registerApplication(JobOpening jo, Candidate c) {
        AddJobApplicationController controller = new AddJobApplicationController();
        return controller.addJobOpeningApplication(jo, c);
    }

    private JobInterview registerInterview(Calendar interviewDate, String interviewTime, JobOpeningApplication jobOpeningApplication) {
        RecordInterviewController controller = new RecordInterviewController();
        return controller.recordInterview(interviewDate, interviewTime, jobOpeningApplication);
    }
}
