local e= a+(b or c)+d

if a>=5 and b or e then
   print("a")
 else
   print("b")
 end

if 5 < (b or c)  then
 print("a")
else
 print("b")
end

if 5 < (b or 2)  then
   print("a")
else
   print("b")
end

local f=5
local d=7
local e={}

if 1<d and 2<(e or {}).id or f and 10>(e or f).id then
   print("a")
else
   print("b")
end

if 1 < d and 5 < (b or c) or 4 < (g or f) then
print("a")
else
print("b")
end


local data=ed.netdata.setname
if result=="success" and data then
   print("a")
 else
   print("b")
 end

if 1 < b or 0 < (v.MCRIT or 0) and 3<d then
   table.insert(equip[tk], {
       id = k,
       name = v.Name,
       lr = v["Display Level"]
   })
else
   print("a")
end

if skill and (skill.info["Damage Type"] == "AD" and self.buff_effects.disarm or skill.info["Damage Type"] ~= "AD" and self.buff_effects.silence) then
   skill:interrupt()
end

local lackHeroConfirm = function(self, callback)
   if ed.player:getHeroAmount() >= 5 and 5 > #(self.team or {}) then
       local info = {
           text = T("你的出战队伍不足五人,是否继续?"),
           rightHandler = callback
       }
       ed.showConfirmDialog(info)
   else
       callback()
   end
end

local lackHeroConfirm2 = function(self, callback)
    return m and 1.35 or 1,(n and 4 or 2)
end

local checkHeroTask = function(self, addhid, removehid, message)
   local a = 1
   local b=2
   local c=3
   local d=4
   local e=5

   if a then
       if b then
           print("b")
       else
           if c then
               if d then
                   print("d")
               elseif e then
                   print("e")
--                    return true
               else
--                    print("f")
               end
           end
       end
   else
       return false
   end
   return false
end

local a = 1
local b=2
local c=3
local d=4
local e=5

if a then
    if b then
        print("b")
    else
        if c then
            if d then
                print("d")
--            elseif e then
--                print("e")
--                --                    return true
            else
--                                    print("f")
            end
--        else
--
        end
    end
else
    return false
end
return false