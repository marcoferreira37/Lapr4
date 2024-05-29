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
        registerOperator("operator", TestDataConstants.PASSWORD1, "Francisco", "Monteiro", "franciscomonteiro@gmail.com");

        registerCustomerManager("customerManager", TestDataConstants.PASSWORD1, "Francisco", "Silveira", "franciscosilveira@gmail.com");

        Candidate candida = registerCandidate("candida", TestDataConstants.PASSWORD1, "Candida", "Candidata", EmailAddress.valueOf("candida@primaDaCunhada.pt"));
        Candidate candida2 = registerCandidate("fatima", TestDataConstants.PASSWORD1, "Fatima", "Couves", EmailAddress.valueOf("fatimaBadGirl@hotmail.com"));
        Candidate candida3 = registerCandidate("maria", TestDataConstants.PASSWORD1, "Maria", "Pereira", EmailAddress.valueOf("vozinha@gmail.com"));
        Candidate candida4 = registerCandidate("fisco", TestDataConstants.PASSWORD1, "Fisco", "Fiasco", EmailAddress.valueOf("fiascos@somosnos.com"));
        Candidate candida5 = registerCandidateWithCurriculum("fisco2", TestDataConstants.PASSWORD1, "Fisco", "Fiasco", EmailAddress.valueOf("fiascos2@somosnos.com"), "Curriculum com jopedrito a fumar ganza no parque ya");






        JobOpening jo = registerJobOpening("bailarino", "casa do ah", Mode.ONSITE, ContractType.FULL_TIME, "baila baila", 1, 1);
        JobOpening jo2 = registerJobOpening("monstro", "o grande lago de penafiel", Mode.ONSITE, ContractType.FULL_TIME, "ARRRGHHHHHH", 1, 1);
        JobOpening jo3 = registerJobOpening("Programador com capacidades de completar o projeto de lapr4", "ISEP", Mode.ONSITE, ContractType.FULL_TIME, "Programador", 1, 1);
        JobOpening jo4 = registerJobOpening("Alguem para acordar o saco", "ISEP", Mode.ONSITE, ContractType.FULL_TIME, "Despertador", 1, 1);

        JobOpeningApplication application = registerApplication(jo, candida);
        JobOpeningApplication application2 = registerApplication(jo, candida2);
        JobOpeningApplication application3 = registerApplication(jo, candida3);
        JobOpeningApplication application4 = registerApplication(jo, candida4);

        JobOpeningApplication application5 = registerApplication(jo2, candida);
        JobOpeningApplication application6 = registerApplication(jo3, candida);
        JobOpeningApplication application7 = registerApplication(jo3, candida2);
        JobOpeningApplication application8 = registerApplication(jo3, candida3);

        Calendar date = Calendar.getInstance();
        JobInterview interview1 = registerInterview(date, "11:00", application5);
        JobInterview interview2 = registerInterview(date, "12:00", application6);
        JobInterview interview3 = registerInterview(date, "13:00", application7);
        JobInterview interview4 = registerInterview(date, "14:00", application8);
        System.out.println(candida);
        System.out.println(candida2);
        System.out.println(candida3);
        System.out.println(candida4);
        System.out.println();
        System.out.print(candida5);

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

        return true;
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
