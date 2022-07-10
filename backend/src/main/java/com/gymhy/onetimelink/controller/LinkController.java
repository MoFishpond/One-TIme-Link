package com.gymhy.onetimelink.controller;

import com.gymhy.onetimelink.domain.LinkService;
import com.gymhy.onetimelink.entity.QueryRequest;
import com.gymhy.onetimelink.entity.QueryResponse;
import com.gymhy.onetimelink.entity.StoreRequest;
import com.gymhy.onetimelink.entity.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
    @PostMapping(path = "/generate")
    public StoreResponse generateLink(@RequestBody StoreRequest request) {
        String url = linkService.generateLinkAndStoreContent(request.getContent());
        return new StoreResponse(url != null, url);
    }

    @CrossOrigin
    @GetMapping(path = "/query")
    public QueryResponse getContent(QueryRequest request) {
        String content = linkService.fetchContent(request.getOneTimeURL());
        return new QueryResponse(content != null, content);
    }
}
