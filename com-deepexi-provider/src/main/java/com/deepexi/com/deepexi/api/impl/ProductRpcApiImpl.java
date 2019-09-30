/**
 * ProductRpcApiImpl  2019/3/27
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.deepexi.com.deepexi.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.com.deepexi.domain.ProductCreateVO;
import com.deepexi.com.deepexi.domain.ProductDTO;
import com.deepexi.com.deepexi.api.ProductRpcApi;
import com.deepexi.com.deepexi.service.ProductService;
import com.deepexi.util.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: rpc调用商品接口实现类
 * @program: dubbo-demo
 * @author: donh
 * @mail: hudong@deepexi.com
 * @date: 2019/3/29 上午11:03
 **/
@Service(version = "1.0")
public class ProductRpcApiImpl implements ProductRpcApi {

    @Autowired
    private ProductService productService;

    @Override
    public ProductDTO getProductById(Long id) {
        ProductDTO product = productService.getProductById(id);
        product.setTag("rpc");
        return product;
    }

    @Override
    public Boolean createProduct(ProductDTO productDTO) {
        ProductCreateVO product = new ProductCreateVO();
        BeanHelper.copyProperties(product, productDTO);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        productService.createProduct(product);
        return true;
    }
}
