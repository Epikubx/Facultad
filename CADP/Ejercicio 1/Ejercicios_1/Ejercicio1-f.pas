programa Ejercicio-1-f

areas
  parte1ciudad : AreaC(1,1,50,50)
  parte2ciudad : AreaP(51,51,99,99)
robots 
  robot tipo1
  comenzar
    mover
    Pos (20,20)
    Pos(40,40)
    Pos(75,78)
  fin
  robot tipo2
  comenzar
    repetir 5
      mover
    Pos(80,80)
  fin
     
variables 
  robot1: tipo1
  robot2: tipo2 
comenzar 
  AsignarArea(robot1,parte1ciudad)
  AsignarArea(robot2,parte1ciudad)
  AsignarArea(robot2,parte2ciudad)
  Iniciar(robot1, 10, 10)
  Iniciar(robot2, 62, 62)
fin
