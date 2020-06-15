package org.flauschhaus.broccoli.category;

import androidx.lifecycle.LiveData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryViewModelTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private LiveData<List<Category>> liveData;

    private CategoryViewModel categoryViewModel;

    @Before
    public void setUp() {
        when(categoryRepository.findAll()).thenReturn(liveData);
        categoryViewModel = new CategoryViewModel(categoryRepository);
    }

    @Test
    public void get_all_categories() {
        assertThat(categoryViewModel.getCategories(), is(liveData));
    }

    @Test
    public void add_category() {
        Category category = new Category("blupp");
        categoryViewModel.add(category);
        verify(categoryRepository).insert(category);
    }

}