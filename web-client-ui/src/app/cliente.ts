import {perfil} from "./perfil";
export class cliente {
    id: number;
    nome: string;
    dependerntes: number;
    cpf: number;
    sexo: string;
    estadocivil: number;
    idade: number;
    uf: number;
    renda: number;
    perfil: perfil;
}