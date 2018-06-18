package com.triplanner.iti.startingrxjava;


/**
 * Created by Hanaa on 6/2/2018.
*/
import com.triplanner.iti.startingrxjava.Day3.Model.DataSource;
import com.triplanner.iti.startingrxjava.Day3.fetures.PostViewModel;

import org.junit.Test;

import io.reactivex.schedulers.TestScheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class ViewModelTest {
    @Test
    public void requestData() {
        DataSource dataSource=new DataSource();
        TestScheduler scheduler = new TestScheduler();
        PostViewModel postViewModel=new PostViewModel();
        postViewModel.getData();
        while (postViewModel.loading.getValue());
        //assertTrue(!postViewModel.moviesSubject.getValue().isEmpty())
        Mockito.verify(postViewModel.moviesSubject).set();
        assertEquals(100,postViewModel.moviesSubject.getValue().size());

    }
}
