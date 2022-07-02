package com.gymhy.redistemplate.controller;

import com.gymhy.redistemplate.domain.LinkService;
import com.gymhy.redistemplate.entity.QueryRequest;
import com.gymhy.redistemplate.entity.QueryResponse;
import com.gymhy.redistemplate.entity.StoreRequest;
import com.gymhy.redistemplate.entity.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongyiming
 */
@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping(path = "/generate")
    public StoreResponse generateLink(@RequestBody StoreRequest request) {
        String url = linkService.generateLinkAndStoreContent(request.getContent());
        return new StoreResponse(url != null, url);
    }

    @GetMapping(path = "/query")
    public QueryResponse getContent(QueryRequest request) {
        String content = linkService.fetchContent(request.getOneTimeURL());
        return new QueryResponse(content != null, content);
    }
}
