package base;

import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;
import ru.oleg.db.dao.ProductsMapper;
import ru.oleg.db.utils.DbUtils;
import ru.oleg.db.utils.RetrofitUtils;
import servises.CategoryService;
import servises.ProductService;

public class BaseTest {

    protected static ProductsMapper productsMapper;
    protected static Retrofit client;
    protected static ProductService productService;
    protected static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
        productsMapper = DbUtils.getProductsMapper();
    }
}