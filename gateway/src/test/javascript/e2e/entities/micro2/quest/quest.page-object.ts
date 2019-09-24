import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class QuestComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-quest div table .btn-danger'));
  title = element.all(by.css('jhi-quest div h2#page-heading span')).first();

  async clickOnCreateButton(timeout?: number) {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(timeout?: number) {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons() {
    return this.deleteButtons.count();
  }

  async getTitle() {
    return this.title.getAttribute('jhiTranslate');
  }
}

export class QuestUpdatePage {
  pageTitle = element(by.id('jhi-quest-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  argsInput = element(by.id('field_args'));
  questInput = element(by.id('field_quest'));
  ans1Input = element(by.id('field_ans1'));
  ans2Input = element(by.id('field_ans2'));
  ans3Input = element(by.id('field_ans3'));
  ans4Input = element(by.id('field_ans4'));

  async getPageTitle() {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setArgsInput(args) {
    await this.argsInput.sendKeys(args);
  }

  async getArgsInput() {
    return await this.argsInput.getAttribute('value');
  }

  async setQuestInput(quest) {
    await this.questInput.sendKeys(quest);
  }

  async getQuestInput() {
    return await this.questInput.getAttribute('value');
  }

  async setAns1Input(ans1) {
    await this.ans1Input.sendKeys(ans1);
  }

  async getAns1Input() {
    return await this.ans1Input.getAttribute('value');
  }

  async setAns2Input(ans2) {
    await this.ans2Input.sendKeys(ans2);
  }

  async getAns2Input() {
    return await this.ans2Input.getAttribute('value');
  }

  async setAns3Input(ans3) {
    await this.ans3Input.sendKeys(ans3);
  }

  async getAns3Input() {
    return await this.ans3Input.getAttribute('value');
  }

  async setAns4Input(ans4) {
    await this.ans4Input.sendKeys(ans4);
  }

  async getAns4Input() {
    return await this.ans4Input.getAttribute('value');
  }

  async save(timeout?: number) {
    await this.saveButton.click();
  }

  async cancel(timeout?: number) {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class QuestDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-quest-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-quest'));

  async getDialogTitle() {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
