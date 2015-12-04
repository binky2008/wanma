
select distinct t.id as id, t.parent_id as parentId, t.name, t.code as description from gtv_org_golden t where t.id >= :groupId
union all
select -1*t1.id, t1.org_id as parentId, t1.NAME, t1.CODE as description 
  from gtv_site t1, gtv_org_golden t2
 where t1.org_id = t2.id
   and t1.type_code = '01'
   and t1.STATUS = 'ENABLE' 
      

select distinct u.id, 
     case when s.parent_site_name not like '%分拨%' then s1.parent_site_id*-1 else s.parent_site_id*-1 end as groupId,
     u.user_name as loginName, u.user_name_cn as userName, u.user_password as password,
     u.email, null as sex, null as birthday, u.owner_site_id as employeeNo, null authMethod
  from gt_user u, gt_site s, gt_site s1
  where u.org_id >= :groupId
    and u.is_enable = 1
    and s.parent_site_id = s1.id
    and s.type != 110
    and s.status = 'ENABLE'
    and s.name not like '%同行%'
    and s.name not like '%营业%'
    and s.name not like '%项目%'
    and user_name = s.code
    
  
  select s.code
  from gt_site s, gt_site s1
  where s.parent_site_id = s1.id
  and s.type<>110
    and s.status = 'ENABLE'
    and s.name not like '%同行%'
    and s.name not like '%营业%'
    and s.name not like '%项目%'
