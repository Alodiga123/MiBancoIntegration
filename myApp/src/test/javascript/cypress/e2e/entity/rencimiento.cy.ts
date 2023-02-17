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

describe('Rencimiento e2e test', () => {
  const rencimientoPageUrl = '/rencimiento';
  const rencimientoPageUrlPattern = new RegExp('/rencimiento(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const rencimientoSample = { telefonoEmisor: 'Granite Plasti', fechaHora: 'Borders' };

  let rencimiento;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/rencimientos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/rencimientos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/rencimientos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (rencimiento) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/rencimientos/${rencimiento.id}`,
      }).then(() => {
        rencimiento = undefined;
      });
    }
  });

  it('Rencimientos menu should load Rencimientos page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('rencimiento');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Rencimiento').should('exist');
    cy.url().should('match', rencimientoPageUrlPattern);
  });

  describe('Rencimiento page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(rencimientoPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Rencimiento page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/rencimiento/new$'));
        cy.getEntityCreateUpdateHeading('Rencimiento');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rencimientoPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/rencimientos',
          body: rencimientoSample,
        }).then(({ body }) => {
          rencimiento = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/rencimientos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/rencimientos?page=0&size=20>; rel="last",<http://localhost/api/rencimientos?page=0&size=20>; rel="first"',
              },
              body: [rencimiento],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(rencimientoPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Rencimiento page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('rencimiento');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rencimientoPageUrlPattern);
      });

      it('edit button click should load edit Rencimiento page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Rencimiento');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rencimientoPageUrlPattern);
      });

      it('edit button click should load edit Rencimiento page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Rencimiento');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rencimientoPageUrlPattern);
      });

      it('last delete button click should delete instance of Rencimiento', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('rencimiento').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response.statusCode).to.equal(200);
        });
        cy.url().should('match', rencimientoPageUrlPattern);

        rencimiento = undefined;
      });
    });
  });

  describe('new Rencimiento page', () => {
    beforeEach(() => {
      cy.visit(`${rencimientoPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Rencimiento');
    });

    it('should create an instance of Rencimiento', () => {
      cy.get(`[data-cy="cedulaBeneficiario"]`).type('84208').should('have.value', '84208');

      cy.get(`[data-cy="telefonoEmisor"]`).type('Front-line Off').should('have.value', 'Front-line Off');

      cy.get(`[data-cy="fechaHora"]`).type('Trafficway program').should('have.value', 'Trafficway program');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(201);
        rencimiento = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response.statusCode).to.equal(200);
      });
      cy.url().should('match', rencimientoPageUrlPattern);
    });
  });
});
