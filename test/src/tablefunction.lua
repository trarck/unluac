local ed={}
ed.h = function()
  return {a = 2}
end

function ed.j()
	return {b=3}
end

local g = h().a

print(g)

local a

local b=(a or {})["c"]

