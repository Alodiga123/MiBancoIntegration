import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('Operations e2e test', () => {
  const operationsPageUrl = '/operations';
  const operationsPageUrlPattern = new RegExp('/operations(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const operationsSample = { cedulaBeneficiario: 'leading' };

  let operations;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/operations+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/operations').as('postEntityRequest');
    cy.intercept('DELETE', '/api/operations/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (operations) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/operations/${operations.id}`,
      }).then(() => {
        operations = undefined;
      });
    }
  });

  it('Operations menu should load Operations page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('operations');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Operations').should('exist');
    cy.url().should('match', operationsPageUrlPattern);
  });

  describe('Operations page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(operationsPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Operations page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/operations/new$'));
        cy.getEntityCreateUpdateHeading('Operations');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', operationsPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/operations',
          body: operationsSample,
        }).then(({ body }) => {
          operations = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/operations+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/operations?page=0&size=20>; rel="last",<http://localhost/api/operations?page=0&size=20>; rel="first"',
              },
              body: [operations],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(operationsPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Operations page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('operations');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', operationsPageUrlPattern);
      });

      it('edit button click should load edit Operations page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Operations');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', operationsPageUrlPattern);
      });

      it('edit button click should load edit Operations page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Operations');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', operationsPageUrlPattern);
      });

      it('last delete button click should delete instance of Operations', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('operations').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', operationsPageUrlPattern);

        operations = undefined;
      });
    });
  });

  describe('new Operations page', () => {
    beforeEach(() => {
      cy.visit(`${operationsPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Operations');
    });

    it('should create an instance of Operations', () => {
      cy.get(`[data-cy="cedulaBeneficiario"]`).type('Australian').should('have.value', 'Australian');

      cy.get(`[data-cy="telefonoEmisor"]`).type('empower USB').should('have.value', 'empower USB');

      cy.get(`[data-cy="telefonoBeneficiario"]`).type('Plastic Health').should('have.value', 'Plastic Health');

      cy.get(`[data-cy="monto"]`).type('streamline digital M').should('have.value', 'streamline digital M');

      cy.get(`[data-cy="bancoEmisor"]`).type('Awes').should('have.value', 'Awes');

      cy.get(`[data-cy="concepto"]`).type('Practical').should('have.value', 'Practical');

      cy.get(`[data-cy="referencia"]`).type('EXE').should('have.value', 'EXE');

      cy.get(`[data-cy="fechaHora"]`).type('Assistant Bahamas').should('have.value', 'Assistant Bahamas');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        operations = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', operationsPageUrlPattern);
    });
  });
});
