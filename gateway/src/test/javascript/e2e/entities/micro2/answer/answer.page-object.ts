import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class AnswerComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-answer div table .btn-danger'));
  title = element.all(by.css('jhi-answer div h2#page-heading span')).first();

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

export class AnswerUpdatePage {
  pageTitle = element(by.id('jhi-answer-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  candInput = element(by.id('field_cand'));
  ansInput = element(by.id('field_ans'));
  answer_questSelect = element(by.id('field_answer_quest'));

  async getPageTitle() {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setCandInput(cand) {
    await this.candInput.sendKeys(cand);
  }

  async getCandInput() {
    return await this.candInput.getAttribute('value');
  }

  async setAnsInput(ans) {
    await this.ansInput.sendKeys(ans);
  }

  async getAnsInput() {
    return await this.ansInput.getAttribute('value');
  }

  async answer_questSelectLastOption(timeout?: number) {
    await this.answer_questSelect
      .all(by.tagName('option'))
      .last()
      .click();
  }

  async answer_questSelectOption(option) {
    await this.answer_questSelect.sendKeys(option);
  }

  getAnswer_questSelect(): ElementFinder {
    return this.answer_questSelect;
  }

  async getAnswer_questSelectedOption() {
    return await this.answer_questSelect.element(by.css('option:checked')).getText();
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

export class AnswerDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-answer-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-answer'));

  async getDialogTitle() {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
