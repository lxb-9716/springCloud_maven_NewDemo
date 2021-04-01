package com.it.springcloud.swagger.service.imp;

import com.alibaba.fastjson.JSON;
import com.it.springcloud.common.page.Paging;
import com.it.springcloud.common.response.ResponseBusinessPage;
import com.it.springcloud.common.response.basic.ResponseBodyPage;
import com.it.springcloud.common.response.basicRes.CommonCode;
import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import com.it.springcloud.model.pojo.jpa.product.Product;
import com.it.springcloud.swagger.repository.mongoLog.LogRepository;
import com.it.springcloud.swagger.repository.product.ProductRepository;
import com.it.springcloud.swagger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    /*保存商品信息*/
    public Product save(Product product) {
        /*注意：当插入的该条数据主键已经存在的时候，会执行更新操作*/
        return productRepository.save(product);
    }

    @Override
    /*根据id删除商品信息*/
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    /*查询所有商品的信息,带分页*/
    @Override
    public ResponseBusinessPage<Product> findAllProductPage(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        Paging<Product> productPaging = new Paging<>();
        ResponseBusinessPage<Product> responseBusinessPage = new ResponseBusinessPage<>();
        LogBean logBean = new LogBean();
        logBean.setCreateDate(new Date());
        logBean.setClassName(this.getClass().getName());
        logBean.setRequestBody("page=" + (page + 1) + "：size=" + size);
        logBean.setMethodName(Thread.currentThread().getStackTrace()[1].getMethodName());
        StringBuffer url = request.getRequestURL();
        String requestType = request.getMethod();
        logBean.setRequestType(requestType);
        if (!StringUtils.isEmpty(url)) {
            logBean.setUrl(url.toString());
        } else {
            logBean.setUrl("请求路径url空");
        }
        if (null != productPage) {
            productPaging.setPage(page + 1);//jpa的分页默认是从0开始的，这里加1，表示第一页
            productPaging.setSize(size);
            productPaging.setTotalPage(productPage.getTotalPages());
            productPaging.setTotalSize(productPage.getTotalElements());
            if (null != productPage.getContent() && productPage.getContent().size() > 0) {
                ResponseBodyPage<Product> responseBody = new ResponseBodyPage<>();
                responseBody.setData(productPage.getContent());
                responseBody.setPaging(productPaging);
                responseBusinessPage.setResponseBodyPage(responseBody);
                responseBusinessPage.setCode(CommonCode.SUCCESS.code());
                responseBusinessPage.setMessage(CommonCode.SUCCESS.message());
            } else {
                responseBusinessPage.setCode(CommonCode.FAIL.code());
                responseBusinessPage.setMessage(CommonCode.FAIL.message());
            }
        }
        logBean.setResponseBody(JSON.toJSONString(responseBusinessPage));
        //保存日志到mongodb数据库中
        LogBean save = logRepository.save(logBean);
        System.out.println(JSON.toJSONString(save));
        return responseBusinessPage;
    }

    /*根据商品id查询商品信息*/
    @Override
    public Product findProductById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = new Product();
        if (optional.isPresent()) {
            product = optional.get();
        }
        LogBean logBean = new LogBean();
        logBean.setCreateDate(new Date());
        logBean.setClassName(this.getClass().getName());
        logBean.setRequestBody(id.toString());
        logBean.setMethodName(Thread.currentThread().getStackTrace()[1].getMethodName());
        Json json = new Json(product.toString());
        logBean.setResponseBody(json.value());
        LogBean save = logRepository.save(logBean);
        System.out.println("===============开始打印日志====================");
        System.out.println(new Json(save.toString()).value());
        System.out.println("================结束打印日志===========================");
        return product;
    }
}
