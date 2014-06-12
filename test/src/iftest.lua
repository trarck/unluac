
--local e= a+(b or c)+d

--if a>=5 and b or c then
--    print("a")
--  else
--    print("b")
--  end
--if 5 < (b or c)  then
--  print("a")
--else
--  print("b")
--end

if 1 < d and 5 < (b or c) and 4 < (e or f) then
    print("a")
  else
    print("b")
  end

--if id and (not hp_info or id > 0 and hp_info[i]._hp_perc ~= 0) then
--if (id and id>0) and not(hp_info and hp_info[i]._hp_perc ==0 ) then
----if a<1 and b and b<2 and (c or d)>2 then
--    print("a")
--else
--    print("b")
--end

--local data=ed.netdata.setname
--if result=="success" and data then
--    print("a")
--  else
--    print("b")
--  end

--if 1 < b or 0 < (v.MCRIT or 0) and 3<d then
--    table.insert(equip[tk], {
--        id = k,
--        name = v.Name,
--        lr = v["Display Level"]
--    })
--else
--    print("a")
--end

--if skill and (skill.info["Damage Type"] == "AD" and self.buff_effects.disarm or skill.info["Damage Type"] ~= "AD" and self.buff_effects.silence) then
--    skill:interrupt()
--end