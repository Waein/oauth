package com.waein.safety.web.controller;

import com.waein.safety.constant.PageConstant;
import com.waein.safety.constant.ResourceNameConstant;
import com.waein.safety.model.dto.PaginatedResult;
import com.waein.safety.model.entity.Nursery;
import com.waein.safety.service.NurseryService;
import com.waein.safety.util.PageUtil;
import com.waein.safety.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * ===================================
 * Created With IntelliJ IDEA
 *
 * @author Waein :)
 * @version method: NurseryController, v 0.1
 * @CreateDate 2018/11/19
 * @CreateTime 14:00
 * @GitHub https://github.com/Waein
 * ===================================
 */
@RestController
@RequestMapping("/nurserys") //这个路径就是在oauth授权配置的请求路径头
public class NurseryController {

    private NurseryService nurseryService;

    /**
     * 使用构造器注入:spring源码使用这种方式
     *
     * @param nurseryService
     */
    @Autowired
    public NurseryController(NurseryService nurseryService) {
        this.nurseryService = nurseryService;
    }

    @GetMapping
    public ResponseEntity<?> getNurserys(@RequestParam(value = "page", required = false) String pageString,
                                         @RequestParam(value = "per_page", required = false) String perPageString) {
        // Parse request parameters
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(nurseryService.getNurserysByPage(page, perPage))
                        .setCurrentPage(page)
                        .setTotalPage(nurseryService.getTotalPage(perPage)));
    }

    @GetMapping("/{nurseryId}")
    public ResponseEntity<?> getNurseryById(@PathVariable Long nurseryId) {
        return nurseryService
                .getNurseryById(nurseryId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(ResourceNameConstant.NURSERY)
                        .setId(nurseryId));
    }

    @PostMapping
    public ResponseEntity<?> postNursery(@RequestBody Nursery nursery) {
        nurseryService.saveNursery(nursery);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nursery.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(nursery);

    }

    @PutMapping("/{nurseryId}")
    public ResponseEntity<?> putNursery(@PathVariable Long nurseryId, @RequestBody Nursery nursery) {
        assertNurseryExist(nurseryId);

        nurseryService.modifyNurseryOnNameById(nursery.setId(nurseryId));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(nursery);
    }

    @DeleteMapping("/{nurseryId}")
//    @RequestMapping("/delete/{nurseryId}")
    public ResponseEntity<?> deleteNursery(@PathVariable Long nurseryId) {
        assertNurseryExist(nurseryId);

        nurseryService.deleteNurseryById(nurseryId);

        return ResponseEntity.noContent().build();
    }

    /********************************** HELPER METHOD **********************************/
    /**
     * 内置私有方法,处理内部方法数据(查询当前id数据是否存在)
     *
     * @param nurseryId
     */
    private void assertNurseryExist(Long nurseryId) {
        nurseryService
                .getNurseryById(nurseryId)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(ResourceNameConstant.NURSERY)
                        .setId(nurseryId));
    }

}
