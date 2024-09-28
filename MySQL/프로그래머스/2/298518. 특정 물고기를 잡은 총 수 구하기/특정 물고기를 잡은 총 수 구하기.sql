select count(*) FISH_COUNT
from fish_info join fish_name_info fni on fish_info.fish_type=fni.fish_type
where fni.fish_name in ('BASS', 'SNAPPER');