package org.spring.es.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.es.bean.Book;
import org.spring.es.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yemengying on 16/1/10.
 */
@Controller
@RequestMapping("/es")
public class EsController {

    Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private BookRepository bookRepository;

    /**
     * 根据名字获取书
     *
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Book> getBookByName( @RequestParam(value = "name") String name) {
        logger.info("根据名字:{}查找书", name);
        return bookRepository.findByName(name);
    }




    /**
     * 根据价格获取书
     *
     * @return
     */
    @RequestMapping(value = "/book/search_price", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Book> getBookByPrice( @RequestParam(value = "price") double price) {
        logger.info("根据价格:{}查找书", price);
        return bookRepository.findByPrice(price);
    }



    /**
     * 新增书
     *
     * @return
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Book indexBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    
    @RequestMapping(value = "/bookadd", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Book indexBookadd() {
    	Book book = new Book();
    	book.setName("cc");
    	book.setPrice(1l);
    	book.setId("1");
    	book.setVersion(1);
        return bookRepository.save(book);
    }


}
