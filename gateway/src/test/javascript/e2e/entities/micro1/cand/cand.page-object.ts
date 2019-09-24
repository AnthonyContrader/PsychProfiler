import { browser, ExpectedConditions, element, by, ElementFinder } from 'protractor';

export class CandComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-cand div table .btn-danger'));
  title = element.all(by.css('jhi-cand div h2#page-heading span')).first();

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

export class CandUpdatePage {
  pageTitle = element(by.id('jhi-cand-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));
  nameInput = element(by.id('field_name'));
  surnameInput = element(by.id('field_surname'));
  ageInput = element(by.id('field_age'));
  experienceInput = element(by.id('field_experience'));
  userInput = element(by.id('field_user'));

  async getPageTitle() {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setNameInput(name) {
    await this.nameInput.sendKeys(name);
  }

  async getNameInput() {
    return await this.nameInput.getAttribute('value');
  }

  async setSurnameInput(surname) {
    await this.surnameInput.sendKeys(surname);
  }

  async getSurnameInput() {
    return await this.surnameInput.getAttribute('value');
  }

  async setAgeInput(age) {
    await this.ageInput.sendKeys(age);
  }

  async getAgeInput() {
    return await this.ageInput.getAttribute('value');
  }

  async setExperienceInput(experience) {
    await this.experienceInput.sendKeys(experience);
  }

  async getExperienceInput() {
    return await this.experienceInput.getAttribute('value');
  }

  async setUserInput(user) {
    await this.userInput.sendKeys(user);
  }

  async getUserInput() {
    return await this.userInput.getAttribute('value');
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

export class CandDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-cand-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-cand'));

  async getDialogTitle() {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(timeout?: number) {
    await this.confirmButton.click();
  }
}
