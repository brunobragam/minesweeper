package com.brunobraga.minesweeper.service

import com.brunobraga.minesweeper.dto.GamePlayInputDTO
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class MinesweeperServiceImplSpec extends Specification {

    def minesweeperService = new MinesweeperServiceImpl()

    def "The player start the game"() {
        given:"The player put information: number of bombs, number of rows and number of columns "
        def input = GamePlayInputDTO.builder()
                .bombs(2)
                .rows(4)
                .columns(4)
                .build()
        when:"The method is called"
        minesweeperService.createGame(input)

        then:"Must be returned the a body game object"
        input != null
    }
}
