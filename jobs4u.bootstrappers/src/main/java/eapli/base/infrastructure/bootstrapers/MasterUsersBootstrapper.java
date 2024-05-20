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

import eapli.base.Domain.Company.AddCompanyController;
import eapli.base.customer.AddJobOpeningController;
import eapli.base.domain.JobApplication.AddJobApplicationController;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.Set;

public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        registerAdmin("admin", TestDataConstants.PASSWORD1, "Jane", "Doe Admin",
                "jane.doe@email.local");
        registerOperator("operator", TestDataConstants.PASSWORD1, "Francisco","Monteiro", "franciscomonteiro@gmail.com");

        registerCustomerManager("customerManager", TestDataConstants.PASSWORD1, "Francisco", "Silveira", "franciscosilveira@gmail.com");

        Candidate candida = registerCandidate("candida", TestDataConstants.PASSWORD1, "Candida", "Candidata", EmailAddress.valueOf("candida@primaDaCunhada.pt"));

        JobOpening jo = registerJobOpening("bailarino","casa do ah",Mode.ONSITE,ContractType.FULL_TIME,"baila baila",1,1);
        JobOpeningApplication application = registerApplication(jo, candida);

        System.out.println(candida);
        System.out.println(jo);
        System.out.println(application);

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

    private Candidate registerCandidate (final String username, final String password, final String firstName,
    final String lastName, final EmailAddress email){
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE);

        SystemUser u = registerUser(username, password, firstName, lastName, String.valueOf(email), roles);
        Candidate c = new Candidate(u, email, new TelephoneNumber(910920930));
        CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();
        candidateRepository.save(c);
        return c;
    }
    private JobOpening registerJobOpening( String description, String address, Mode mode,ContractType contractType, String title,int vacancies ,int c){
        AddJobOpeningController controller = new AddJobOpeningController();
       return controller.addJobopening(description,address,mode,contractType,title,vacancies, c);
    }

    private JobOpeningApplication registerApplication(JobOpening jo, Candidate c) {
        AddJobApplicationController controller = new AddJobApplicationController();
        return controller.addJobOpeningApplication(jo, c);
    }
}
