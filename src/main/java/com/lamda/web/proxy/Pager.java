package com.lamda.web.proxy;

import com.lamda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
            pageCount, pageSize, startPage, endPage, nowPage,
            blockCount, blockSize, prevBlock, nextBlock, nowBlock;
    private boolean exisPrev, exisNext;
    public void paging(){
        rowCount = movieMapper.count();
        pageSize = 5;
        pageCount = (rowCount%pageSize != 0)? rowCount/pageSize+1 : rowCount/pageSize;
        blockSize = 5;
        blockCount = (pageCount%blockSize != 0)? pageCount/blockSize+1 : pageCount/blockSize;
        nowPage = 1;
        startRow = (nowPage-1) * pageSize + 1;
        endRow = (nowPage != pageCount)? nowPage * pageSize : rowCount;
        nowBlock = (nowPage % blockSize != 0)? nowPage / blockSize + 1 : nowPage / blockSize;
        startPage = nowBlock * blockSize + 1;
        endPage = (nowBlock != blockCount)? nowBlock*blockSize : pageCount;
        prevBlock = startPage - blockSize;
        nextBlock = startPage + blockSize;
        exisPrev = (nowBlock != 1);
        exisNext = (nowBlock != blockCount)? true : false;
    }
}
