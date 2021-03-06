package com.clsaa.dop.server.baas.Mapper;

import com.clsaa.dop.server.baas.model.dbMo.ChaincodeInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 注释写在这
 *
 * @author Monhey
 */
@Mapper
@Repository
public interface ChaincodeMapper {

    @Select("select * from chaincode")
    public List<ChaincodeInfo> getAllChaincode();

    @Insert("insert into chaincode (ChaincodeName,ChaincodeVersion,git,ChannelId,NetId) values (#{ChaincodeName},#{ChaincodeVersion},#{git},#{ChannelId},#{NetId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void insertChaincode(ChaincodeInfo chaincodeInfo);
}
