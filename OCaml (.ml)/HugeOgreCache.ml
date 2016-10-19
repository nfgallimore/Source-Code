let lst : float list = 
	[2490.0; 2600.0; 2697.0; 2698.0; 2699.0; 2700.0; 2798.0; 2798.0; 2798.0; 2798.0; 2799.0; 2800.0; 3098.0; 3098.0; 3098.0; 3099.0; 3099.0; 3100.0; 3349.0; 3350.0; 3797.0; 3798.0; 3799.0; 4000.0; 4183.0; 12999.0; 12999.0; 12999.0]

let sum : float = 
	List.fold_left (+.) 0. lst

let len : float = 
	float_of_int (List.length lst)

let mean : float = 
	sum /. len

let std = sqrt (((List.fold_left (-.) mean lst) ) /. (len -. 1.))


let sqr x = x *. x

let stddev l =
  	let n, sx, sx2 =
    	List.fold_left
    		(fun (n, sx, sx2) x -> succ n, sx +. x, sx2 +. sqr x)
			(0, 0., 0.) l
  	in
  	sqrt ((sx2 -. sqr sx /. float n) /. float n)

let _ =
	let l = [2490.0; 2600.0; 2697.0; 2698.0; 2699.0; 2700.0; 2798.0; 2798.0; 2798.0; 2798.0; 2799.0; 2800.0; 3098.0; 3098.0; 3098.0; 3099.0; 3099.0; 3100.0; 3349.0; 3350.0; 3797.0; 3798.0; 3799.0; 4000.0; 4183.0; 12999.0; 12999.0; 12999.0]
 	in
  	Printf.printf "List: ";
  	List.iter (Printf.printf "%g  ") l;
  	Printf.printf "\nStandard deviation: %g\n" (stddev l)

stddev [2490.0; 2600.0; 2697.0; 2698.0; 2699.0; 2700.0; 2798.0; 2798.0; 2798.0; 2798.0; 2799.0; 2800.0; 3098.0; 3098.0; 3098.0; 3099.0; 3099.0; 3100.0; 3349.0; 3350.0; 3797.0; 3798.0; 3799.0; 4000.0; 4183.0];;