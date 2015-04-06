/*Claudio Ruz Castro
Ejercicio 2*/

#include<stdlib.h>//include de librerias 
#include<ctype.h>
#include<stdio.h>
#include<string.h>

int main()//inicio del programa
{
    system("color B");
char vector[300];//declaracion dekl vector
int largo=0,contNU=0,contM=0,contMi=0,i,acum=0;//declaracion de contadores y variables
printf("La oracion a anlisar es \n");
gets(vector);
printf(vector);//muestro vector
largo=strlen(vector);//saco el largo del vector para tener el tope en cilco for
for(i=0;i<largo;i++)
{
//ocupe del sentencias if para ingresar
if (isdigit(vector[i])) contNU++;//funcion que discrimina digitos,despues las sumo
if (isupper(vector[i])) contM++;//funcion que discrimina mayusculas,depues las sumo
if(islower(vector[i])) contMi++;//funcion que discrimina las minusculas ,depues las sumo
}
//imporesion  en el orden numeros,mayusculas y minusculas
printf("\nla cantidad de numeros es %d \n ",contNU);
printf("\nla cantidad de mayusculas es %d\n",contM);
printf("\nla cantidad de minusculas es %d\n",contMi);

getchar();
getchar();
//fin del programa
}
