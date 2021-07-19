package com.brunobraga.minesweeper.service

import com.brunobraga.minesweeper.component.NewGameComponent
import com.brunobraga.minesweeper.domain.GamePlay
import com.brunobraga.minesweeper.dto.GamePlayInputDTO
import spock.lang.Specification

class MinesweeperServiceImplSpec extends Specification {

    def newGameComponent = Mock(NewGameComponent)
    def minesweeperService = new MinesweeperServiceImpl(newGameComponent)

    def "The player start the game"() {
        given: "The player put information: number of bombs, number of rows and number of columns "
        def input = GamePlayInputDTO.builder()
                .bombs(2)
                .rows(4)
                .columns(4)
                .build()

        when: "The method is called"
        def response = minesweeperService.createGame(input)

        then: "Must be returned the a body game object"
        response.getGameId() != null

        and:
        newGameComponent.execute(_) >> new GamePlay()
    }
}
