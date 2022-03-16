package com.ego.item.service;

import com.ego.commons.ResponseData.portal.PortalMenu;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ItemPortalCatService {

    PortalMenu showCatMenu();

}
