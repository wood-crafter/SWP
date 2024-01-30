package com.example.swp.constants;

import java.util.Arrays;
import java.util.List;

public class RequestMappingConstant {

    public static final String SIGN_IN_API = "/api/auth/sign-in";

    public static final String SIGN_UP_API = "/api/auth/sign-up";

    public static final String SIGN_OUT_API = "/api/auth/sign-out";
    public static final String ME_API = "/api/auth/me";

    public static final String FIND_ALL_EMPLOYEE_API = "/api/employees";
    public static final String FIND_ALL_PRODUCT_API = "/api/products";

    public static final String PRODUCT_DETAIL_API = "/api/products/**";
    public static final String IMAGE_API = "/api/image/**";

    public static final String ADD_CART_API = "/api/cart/add";

    public static final String FIND_ALL_CATEGORY_API = "/api/categories";
    public static final String FIND_ALL_BANNER_API = "/api/banners";

    public static final String FIND_ALL_SUPPLIER_API = "/api/suppliers";

    public static final List<String> FREE_API = Arrays.asList(
            SIGN_IN_API,
            SIGN_UP_API,
            SIGN_OUT_API,
            FIND_ALL_PRODUCT_API,
            PRODUCT_DETAIL_API,
            IMAGE_API,
            FIND_ALL_CATEGORY_API,
            FIND_ALL_BANNER_API,
            FIND_ALL_SUPPLIER_API);

}
