[![Build Status](https://travis-ci.org/ikibis/job4j.svg?branch=master)](https://travis-ci.org/ikibis/job4j/algorithm)
[![codecov](https://codecov.io/gh/ikibis/job4j/branch/master/graph/badge.svg)](https://codecov.io/gh/ikibis/job4j/algorithm)

Задания :

21. Задач список скриптов с указанием их зависимосей.
    1 - [2, 3], 2 - [4], 3 - [4, 5], 4 - [], 5 - []
    Необходим написать метод, который возвращает список всех скриптов, которые нужно для загрузки входящего скрипта.
    Например, чтобы выполнить скрипт 1. нужно выполнить скрипт (2, 3), которые в свою очередь зависят от 4 и 5 скрипта.
    List load(Map<Integer, List ds, Integer scriptId)

22. Задан двухмерных массив. Массив заполнен числами. По массиву двигается робот. 
    Робот может двигаться вниз, вверх и вправо. Задача начальная точка и конечная. 
    Перемещение из одной ктелки в другую затрачивает энергацию. Рассчитывается она разность модуля значений клетов. 
    Например, ход из клетки 1 в 10 будет оцениваться в 9 единиц. Необходимо написать метод, который определяет наименее трудозатратный путь.
    int optimalWay(int[][] board, int sx, int sy, int fx, int fy)
    [1, 2, 3]
    [1, 3, 6]
    [1, 1, 5] 
    start (0, 0), finish (3, 3). Ответ: 4. Путь 1 1 1 1 5

23. Задач двухмерный массив. Массив заполнен нулями и единицами. Робот может ходить только по единицам. 
    Задача начальная и конечная точка. Робот может ходить вверх, вних, влево и вправо. 
    Необходимо найти минимальный путь до конечной точки.
    int minWay(int[][] board, int sx, int sy, int fx, int fy)

