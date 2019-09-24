/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../../page-objects/jhi-page-objects';

import { QuestComponentsPage, QuestDeleteDialog, QuestUpdatePage } from './quest.page-object';

const expect = chai.expect;

describe('Quest e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let questUpdatePage: QuestUpdatePage;
  let questComponentsPage: QuestComponentsPage;
  let questDeleteDialog: QuestDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Quests', async () => {
    await navBarPage.goToEntity('quest');
    questComponentsPage = new QuestComponentsPage();
    await browser.wait(ec.visibilityOf(questComponentsPage.title), 5000);
    expect(await questComponentsPage.getTitle()).to.eq('gatewayApp.micro2Quest.home.title');
  });

  it('should load create Quest page', async () => {
    await questComponentsPage.clickOnCreateButton();
    questUpdatePage = new QuestUpdatePage();
    expect(await questUpdatePage.getPageTitle()).to.eq('gatewayApp.micro2Quest.home.createOrEditLabel');
    await questUpdatePage.cancel();
  });

  it('should create and save Quests', async () => {
    const nbButtonsBeforeCreate = await questComponentsPage.countDeleteButtons();

    await questComponentsPage.clickOnCreateButton();
    await promise.all([
      questUpdatePage.setArgsInput('args'),
      questUpdatePage.setQuestInput('quest'),
      questUpdatePage.setAns1Input('ans1'),
      questUpdatePage.setAns2Input('ans2'),
      questUpdatePage.setAns3Input('ans3'),
      questUpdatePage.setAns4Input('ans4')
    ]);
    expect(await questUpdatePage.getArgsInput()).to.eq('args', 'Expected Args value to be equals to args');
    expect(await questUpdatePage.getQuestInput()).to.eq('quest', 'Expected Quest value to be equals to quest');
    expect(await questUpdatePage.getAns1Input()).to.eq('ans1', 'Expected Ans1 value to be equals to ans1');
    expect(await questUpdatePage.getAns2Input()).to.eq('ans2', 'Expected Ans2 value to be equals to ans2');
    expect(await questUpdatePage.getAns3Input()).to.eq('ans3', 'Expected Ans3 value to be equals to ans3');
    expect(await questUpdatePage.getAns4Input()).to.eq('ans4', 'Expected Ans4 value to be equals to ans4');
    await questUpdatePage.save();
    expect(await questUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await questComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Quest', async () => {
    const nbButtonsBeforeDelete = await questComponentsPage.countDeleteButtons();
    await questComponentsPage.clickOnLastDeleteButton();

    questDeleteDialog = new QuestDeleteDialog();
    expect(await questDeleteDialog.getDialogTitle()).to.eq('gatewayApp.micro2Quest.delete.question');
    await questDeleteDialog.clickOnConfirmButton();

    expect(await questComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
