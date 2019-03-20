package com.tomo.webservice.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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


    @Test
    public void mockitoTest(){
        // mock 생성
        List mockedList = mock(List.class);

        // mock 객체 사용
        mockedList.add("one");
        mockedList.add("two");

        // 검증
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    @Test
    public void mockito_stubbing(){
        // interface분 아니라 구체 클래스를 mock으로...
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 첫번째 element
        System.out.println(mockedList.get(0));

        // runtime exception
//        System.out.println(mockedList.get(1));

        // 999번째 element 얻어오는 부분은 stub 되지 않으므로 null 출력
        System.out.println(mockedList.get(999));

        /*
        stubbing 된 부분이 호출되는지 확인할 수 있지만, 불필요한 일이다.
        만일 코드에서 get(0)의 리턴값을 확인하려고 하면, 다른 어딘가의 테스트가 깨진다.
        만일 코드에서 get(0)의 리턴값에 관심이 없다면, stubbing되지 않았어야 한다.
         */
        verify(mockedList).get(0);
    }
}