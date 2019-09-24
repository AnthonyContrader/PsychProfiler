
/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {
   id: number;
   activated: true;  
  email: string;
  firstName: string;
  imageUrl: null;
  langKey: null;
  lastName: null;
  login: string;
  resetDate: string;

  authorities: string[]=[""];

}

