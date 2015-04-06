/*Claudio Ruz Castro*/
/*Ejercicio   1*/
//Nota:siempre incluyo librerias aunque no las utilice todas
#include <stdio.h>//libreria principal del programa
#include <stdlib.h>//libreria para el color
#include <string.h>//libreria para el caracter
#include <math.h>//libreria de formulas matemAaticas

int main(){//inicio del programa
    system("color b");
    int i=0,vectorA[22],vectorB[22],veces=0,multi=0,acum=0;//declaracion de variables y vectores
    printf("cuantos valores desea ingresae en el vector?\n");
    scanf("%d",&veces);//guardo las veces o largo del vector
    printf("ingrese numeros al vector A\n");
    for(i=0;i<veces;i++){//ciclo para el llenado del vector A
    scanf("%d",&vectorA[i]);
}
printf("ingrese numeros al vector B\n" );
 for(i=0;i<veces;i++){
    scanf("%d",&vectorB[i]);
}
printf("el vector A es");
    for(int i=0;i<veces;i++){//muestro el vector A
               printf("[%d]",vectorA[i]);
             
               
               }printf("\n");


   printf("el vector B es");//muestro el vector A
   for(int i=0;i<veces;i++){
               printf("[%d]",vectorB[i]);
               }
              
    printf("\n\n \n  LA MULTIPLICACION DE POSICION SEGUN SUS DIGITOS ES\n");
     for(int i=0;i<veces;i++){
             multi=vectorA[i] * vectorB[i]; //calculo de multiplicacion  de indices
             acum+=multi;//suma total de la multiplicacion de sus indices
             printf("al multiplicar [%d]*[%d]",vectorA[i],vectorB[i]);//muestra valores a multiplicar
             printf("de la posicion %d del vector es %d\n",i,multi);
             
             
             }    
             
    printf("la suma es %d\n",acum);
    printf("a suma del resultado de la multiplicacion es ");
    if(acum<=50){
                 printf("menor que 50");}
    if(acum>=100){
                  printf("mayor a 100");}
    if(acum>100 & acum<=500){
                printf("menor a 500");}
    getchar();
    getchar();//fin del programa
    
    
    }
