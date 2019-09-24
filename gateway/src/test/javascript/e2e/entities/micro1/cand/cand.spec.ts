/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { CandComponentsPage, CandDeleteDialog, CandUpdatePage } from './cand.page-object';

const expect = chai.expect;

describe('Cand e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let candUpdatePage: CandUpdatePage;
  let candComponentsPage: CandComponentsPage;
  let candDeleteDialog: CandDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Cands', async () => {
    await navBarPage.goToEntity('cand');
    candComponentsPage = new CandComponentsPage();
    await browser.wait(ec.visibilityOf(candComponentsPage.title), 5000);
    expect(await candComponentsPage.getTitle()).to.eq('gatewayApp.micro1Cand.home.title');
  });

  it('should load create Cand page', async () => {
    await candComponentsPage.clickOnCreateButton();
    candUpdatePage = new CandUpdatePage();
    expect(await candUpdatePage.getPageTitle()).to.eq('gatewayApp.micro1Cand.home.createOrEditLabel');
    await candUpdatePage.cancel();
  });

  it('should create and save Cands', async () => {
    const nbButtonsBeforeCreate = await candComponentsPage.countDeleteButtons();

    await candComponentsPage.clickOnCreateButton();
    await promise.all([
      candUpdatePage.setNameInput('name'),
      candUpdatePage.setSurnameInput('surname'),
      candUpdatePage.setAgeInput('5'),
      candUpdatePage.setExperienceInput('experience'),
      candUpdatePage.setUserInput('user')
    ]);
    expect(await candUpdatePage.getNameInput()).to.eq('name', 'Expected Name value to be equals to name');
    expect(await candUpdatePage.getSurnameInput()).to.eq('surname', 'Expected Surname value to be equals to surname');
    expect(await candUpdatePage.getAgeInput()).to.eq('5', 'Expected age value to be equals to 5');
    expect(await candUpdatePage.getExperienceInput()).to.eq('experience', 'Expected Experience value to be equals to experience');
    expect(await candUpdatePage.getUserInput()).to.eq('user', 'Expected User value to be equals to user');
    await candUpdatePage.save();
    expect(await candUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await candComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Cand', async () => {
    const nbButtonsBeforeDelete = await candComponentsPage.countDeleteButtons();
    await candComponentsPage.clickOnLastDeleteButton();

    candDeleteDialog = new CandDeleteDialog();
    expect(await candDeleteDialog.getDialogTitle()).to.eq('gatewayApp.micro1Cand.delete.question');
    await candDeleteDialog.clickOnConfirmButton();

    expect(await candComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
