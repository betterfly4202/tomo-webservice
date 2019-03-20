package com.tomo.webservice.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.03.20
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleRepositoryTest {

    @Autowired
    private SampleRepository repository;

    @After
    public void cleanUp(){
//        repository.deleteAll();
    }

    @Test
    public void 샘플_저장(){
        // given
        repository.save(Sample.builder()
                .title("샘플_제목_1")
                .content("샘플_내용_1")
                .author("betterfly")
                .build());

        // when
        List<Sample> sampleList = repository.findAll();

        // then
        Sample sample = sampleList.get(0);
        assertThat(sample.getTitle(), is("샘플_제목_1"));
        assertThat(sample.getAuthor(), is("betterfly"));

    }
}