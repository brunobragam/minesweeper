package com.brunobraga.minesweeper.component

import com.brunobraga.minesweeper.domain.GamePlay
import spock.lang.Specification

class NewGameComponentSpec extends Specification {

    def boardComponent = new BoardComponent()
    def newGameComponent = new NewGameComponent(boardComponent)

    def "The component executes the creation process of the random position of the bomb"() {
        given: "The player given valid inputs."
        def input = new GamePlay(2, 4, 4)
        def numberOfBoardPositions = input.getUserInputedRows() * input.getUserInputedColumns()

        when: "The principal method is called"
        def response = newGameComponent.execute(input)

        then: "Must be return a board with exacly positions for number os rows and columns inserted"
        response.getBoardGame().size() == numberOfBoardPositions


    }
}
