# language: es
Caracteristica: jugadores

Escenario: Mover un jugador a la izquierda
    Dada un jugador
    Cuando me muevo a la izquierda "3" posiciones
    Entonces el jugador ha cambiado de posicion
    
Escenario: Mover un jugador a la derecha
    Dada un jugador
    Cuando me muevo a la derecha "2" posiciones
    Entonces el jugador ha cambiado de posicion
    
Escenario: Ganar un quesito
    Dada un jugador
    Cuando gano un quesito de color verde
    Entonces el jugador tiene "1" quesito