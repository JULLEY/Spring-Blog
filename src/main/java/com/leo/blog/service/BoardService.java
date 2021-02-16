package com.leo.blog.service;

import com.leo.blog.dto.ReplySaveRequestDto;
import com.leo.blog.model.Board;
import com.leo.blog.model.User;
import com.leo.blog.repository.BoardRepository;
import com.leo.blog.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void save(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    /**
     * 글 목록 조회
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    public Page<Board> selectBoardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    /**
     * 글 상세조회
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Board selectBoardDetail(int id){
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    /**
     * 글 삭제
     * @param id
     */
    @Transactional
    public void deleteBoard(int id) {
        log.debug("삭제대상 ID : " + id);
        boardRepository.deleteById(id);
    }

    /**
     * 글 수정
     * @param id
     * @param param
     */
    @Transactional
    public void update(int id, Board param){
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료

        board.setTitle(param.getTitle());
        board.setContent(param.getContent());
        // 해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료. 이때 더티체킹 - 자동 업데이트가 됨. db flush (커밋이 된다)
    }

    @Transactional
    public void replySave(ReplySaveRequestDto replySaveRequestDto) {
        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println("댓글저장 success cnt : "+result);
    }
}
